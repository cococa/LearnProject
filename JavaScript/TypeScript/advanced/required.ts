//将某个类型里的属性全部变为必选项

interface RequiredType {
  id: number;
  firstName?: string;
  lastName?: string;
}

function testWithRquired(res: Required<RequiredType>) {
  console.log(res);
}

// testWithRquired({ id: 1 });
