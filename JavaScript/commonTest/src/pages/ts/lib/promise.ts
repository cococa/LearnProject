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
  //待定、已履行或已拒绝
  PENDING = "pending",
  FULFILLED = "fulfilled",
  REJECTED = "rejected",
}

//定义 Promise 的then 方法
interface IPromise {
  then(onFulfilled?: any, onRejected?: any): IPromise;
}

export default class MyPromise implements IPromise {
  _id: number = 0;
  value: any;
  reson: any;
  state: PromiseState = PromiseState.PENDING;
  _fulfilledStack: any[] = [];
  _rejectStack: any[] = [];

  // log(...p: string[]) {
  //   console.log("MyPromise", ...p);
  // }

  constructor(params: PromiseParams) {
    const _resolve = (value: any) => {
      console.log("constructor value", value, this.state, this._id);
      // this._fulfilledStack && this._fulfilledStack.forEach((fn) => console.log(fn));
      if (this.state === PromiseState.PENDING) {
        this.value = value;
        this.state = PromiseState.FULFILLED;
        this._fulfilledStack && this._fulfilledStack.forEach((fn) => fn(value));
      }
    };
    const _reject = (reson: any) => {
      console.log("constructor reson", reson);
      if (this.state === PromiseState.PENDING) {
        this.reson = reson;
        this.state = PromiseState.REJECTED;
        this._rejectStack && this._rejectStack.forEach((fn) => fn(reson));
      }
    };
    this._id = Math.random();
    params(_resolve, _reject);
  }

  public instanceOfIPromise(obj: any) {
    return (
      Object.prototype.hasOwnProperty.call(obj, "then") &&
      typeof obj["then"] === "function"
    );
  }

  public then(onFulfilled?: any, onRejected?: any): MyPromise {
    return new MyPromise((resolve, reject) => {
      if (this.state === PromiseState.FULFILLED) {
        // 处理上一个then返回的promise, 这里要注意两个问题，
        // 如果用  instanceof MyPromise 判断，会丢失了Promise的扩展性，举个例子，我可以用原生的Promise，这里就会出问题
        // 根据 Promise A+ 规范，如果一个类有then方法，那么就认为是一个Promise
        // console.log("debug", this.implementsInterface(this.value, IPromise));
        if (this.instanceOfIPromise(this.value)) {
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
          console.log("onFulfilled add task", onFulfilled);
          console.log("onFulfilled add task", this._fulfilledStack.length);
          this._fulfilledStack.push((val: any) => {
            console.log("debug1", val);
            const _res = onFulfilled(val);
            console.log("debug2", _res);
            resolve(_res);
          });
          console.log(
            "onFulfilled after add task",
            this._fulfilledStack.length
          );
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
