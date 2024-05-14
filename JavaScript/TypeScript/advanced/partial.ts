
//Partial 允许你将T类型的所有属性设为可选

interface PartialType {
    id: number;
    firstName: string;
    lastName: string;
}

// type Partial<T> = {
//     [P in keyof T]?: T[P];
// };

function testWithPartial(res : Partial<PartialType>) {
    console.log(res);
}


function testWithout(res : PartialType) {
    console.log(res);
}

testWithPartial({});

// error [ Argument of type '{}' is not assignable to parameter of type 'PartialType'.]
// testWithout({});
