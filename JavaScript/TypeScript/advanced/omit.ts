type MyOmit<T extends any, K extends keyof T> = {
  [P in keyof T as P extends K ? never : P]: T[P];
};

// keyof T 提取 T 的所有键。
// as P extends K ? never : P 使用条件类型来决定是否保留键 P。如果 P 是 K 的子集，那么返回 never，否则返回 P。
// [P in keyof T as P extends K ? never : P]: T[P] 构建一个新的类型，其中只包含那些不在 K 中的键。


// 这里重点的是as P 


interface Todo {
  title: string;
  description: string;
  completed: boolean;
}

type TodoPreview = MyOmit<Todo, "description" | "title">;

const todo: TodoPreview = {
  completed: false,
};

