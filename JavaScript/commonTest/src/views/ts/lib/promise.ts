interface Resolve {
  (str: any): void;
}

interface Reject {
  (str: any): void;
}

interface PromiseParams {
  (resolve: Resolve, reject: Reject): void;
}

enum PromiseState {
  PENDING = "pending",
  FULFILLED = "fulfilled",
  REJECTED = "rejected",
}

// 参考文档   https://juejin.cn/post/7222310732293570619

export default class MyPromise {
  value: any;
  reson: any;
  state: PromiseState = PromiseState.PENDING;
  _fulfilledStack: any[] = [];
  _rejectStack: any[] = [];

  log(...p: string[]) {
    // console.log("MyPromise", ...p);
  }

  constructor(params: PromiseParams) {
    const _resolve = (value: any) => {
      this.log("value", value);
      if (this.state === PromiseState.PENDING) {
        this.value = value;
        this.state = PromiseState.FULFILLED;
        this._fulfilledStack && this._fulfilledStack.forEach((fn) => fn(value));
      }
    };
    const _reject = (reson: any) => {
      this.log("reson", reson);
      if (this.state === PromiseState.PENDING) {
        this.reson = reson;
        this.state = PromiseState.REJECTED;
        this._rejectStack && this._rejectStack.forEach((fn) => fn(reson));
      }
    };
    params(_resolve, _reject);
  }

  public then(onFulfilled: any, onRejected?: any): MyPromise {
    return new MyPromise((resolve, reject) => {
      if (this.state === PromiseState.FULFILLED) {
        // 处理上一个then返回的promise
        console.log("debug", this.value instanceof MyPromise);
        if (this.value instanceof MyPromise) {
          this.value.then(
            (val: any) => {
              const _res = onFulfilled(val);
              resolve(_res);
            },
            (reson: any) => {
              const _res = onRejected(reson);
              reject(_res);
            }
          );
        } else {
          const _res = onFulfilled(this.value);
          resolve(_res);
        }
      }
      if (this.state === PromiseState.REJECTED) {
        if (onRejected) {
          const _res = onRejected(this.reson);
          reject(_res);
        }
      }
      if (this.state === PromiseState.PENDING) {
        if (onFulfilled) {
          this._fulfilledStack.push((val: any) => {
            const _res = onFulfilled(val);
            resolve(_res);
          });
        }

        if (onRejected) {
          this._rejectStack.push((val: any) => {
            const _res = onRejected(val);
            reject(_res);
          });
        }
      }
    });
  }
}
