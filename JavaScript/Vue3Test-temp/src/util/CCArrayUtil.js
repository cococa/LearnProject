// array
/**
 * 根据key-value 查询数组中的对象
 * @param {*} list 查询的数组
 * @param {*} key  查询的key
 * @param {*} value 查询的key对应的value
 * @returns
 */
export function findElementBy(list, key, value) {
//   if (!list || list.length == 0) {
//     return null;
//   }
  let result = null;
  for (var i = 0; i < list.length; i++) {
    const element = list[i];
    if (element[key] == value) {
      result = element;
      break;
    }
  }
  return result;
}

// https://docs.swift.org/swift-book/LanguageGuide/CollectionTypes.html
// Use the intersection(_:) method to create a new set with only the values common to both sets.
// Use the symmetricDifference(_:) method to create a new set with values in either set, but not both.
// Use the union(_:) method to create a new set with all of the values in both sets.
// Use the subtracting(_:) method to create a new set with values not in the specified set.

/**
 * 时间复杂度 
 * @param {*} array0
 * @param {*} array1
 * @returns  (去重后的数据)
 *
 * js Set 兼容性
 * https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Set
 */
export function union(array0, array1) {
  // optimize
  if (!Array.isArray(array0) || !Array.isArray(array1)) {
    return [];
  }
  let mSet = new Set(array0);
  array1.forEach((element) => {
    mSet.add(element);
  });
  return Array.from(mSet);
}

/**
 * 查询两个数组的交集（去重）
 * @param {*} array0 
 * @param {*} array1 
 * @returns 
 */
export function intersection(array0, array1) {
  if (!Array.isArray(array0) || !Array.isArray(array1)) {
    return [];
  }
  let mSet = new Set();
  array0.forEach((element0) => {
    array1.forEach((element1) => {
      if (element0 == element1) {
        mSet.add(element1);
      }
    });
  });
  return Array.from(mSet);
}

   