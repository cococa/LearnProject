/**
 *  // 深拷贝
 *  // example
 *  const a = { foo: 'bar', obj: { a: 1, b: 2 } };
 *  const b = deepClone(a); // a !== b, a.obj !== b.obj
 *
 * @param {
 * } obj
 * @returns
 */

function deepClone(obj) {
  if (obj === null) return null;
  let clone = Object.assign({}, obj);
  Object.keys(clone).forEach(
    (key) =>
      (clone[key] =
        typeof obj[key] === "object" ? deepClone(obj[key]) : obj[key])
  );
  if (Array.isArray(obj)) {
    clone.length = obj.length;
    return Array.from(clone);
  }
  return clone;
}

export default deepClone;



/**
 *
 *
 * //example
 * URLJoin('http://www.google.com', 'a', '/b/cd', '?foo=123', '?bar=foo');
 * 'http://www.google.com/a/b/cd?foo=123&bar=foo'
 *
 *
 * @param  {...any} args
 * @returns
 */
export function URLJoin(...args) {
  return args
    .join("/")
    .replace(/[\/]+/g, "/")
    .replace(/^(.+):\//, "$1://")
    .replace(/^file:/, "file:/")
    .replace(/\/(\?|&|#[^!])/g, "$1")
    .replace(/\?/g, "&")
    .replace("&", "?");
}

export const ArrayUtil = {
  testArray: function () {
    console.log("testArray");
  },
};


export function test2Fun() {
  return "hello world"
}

// let PI= 3.1415926;
export const PI = 3.1415926;