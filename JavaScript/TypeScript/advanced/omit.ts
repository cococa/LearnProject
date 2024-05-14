interface OmitType {
    id: number;
    firstName: string;
    lastName: string;
}

type omit = Omit<OmitType, 'id' | 'firstName'>;
// 经过Omit后，新类型只包含了lastName属性
// type omit = {
//     lastName: string;
// }


// 源码
// type Omit<T, K extends keyof any> = Pick<T, Exclude<keyof T, K>>;

