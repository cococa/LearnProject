
interface IPerson{
    id: number;
    age: number;
    address: string;
}

// 此方法允许你从一个已存在的类型 T中选择一些属性作为K, 从而创建一个新类型


type PickType = Pick<IPerson, 'id' | 'age'>;
// 经过Pick后，新类型只包含了id和age属性
// type PickType = {
//     id: number;
//     age: number;
// } 



// 源码
// type Pick<T, K extends keyof T> = {
//     [P in K]: T[P];
// };