class Point{
  x : number
  y : number
}
const p1 : Readonly<Point> ={ x : 10, y :20};
// a.x = 109

console.log(p1);


let readonlyArray : ReadonlyArray<number> =  [1,2,3]

// readonlyArray.push(1);   //Property 'push' does not exist on type 'readonly number[]'.

console.log(readonlyArray);
