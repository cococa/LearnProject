// js Array 扩展

Array.prototype.log = function(){
  console.log('Array log',this)
}

Array.prototype.remove = function(index, len){
  return this.splice(index,len);
}

// 貌似不需要，filter 此类的操作也可以
Array.prototype.removeAll = function(predicate){
  const result =  [];
  this.forEach((element,index,array) => {
      if(!predicate(element,index,array)){
          result.push(element);
      }
  });
  return result;
}




