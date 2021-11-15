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

// array
/**
 * 根据key-value 查询数组中的对象
 * @param {*} list 查询的数组
 * @param {*} key  查询的key
 * @param {*} value 查询的key对应的value
 * @returns
 */
function findListByKv(list, key, value) {
  let result = null;
  list &&
    key &&
    list.forEach((element) => {
      if (element[key] == value) {
        result = element;
      }
    });
  return result;
}

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
