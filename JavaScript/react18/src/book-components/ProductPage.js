import { useCallback, useState } from "react";

const funcsMap = new Map();
 
export const rec = (tag, fn) => {
  if (!funcsMap.has(tag)) {
    funcsMap.set(tag, []);
  }
  const funcs = funcsMap.get(tag);
  if (funcs.includes(fn)) {
    console.log(`[${tag}] fn exists`);
  } else {
    funcs.push(fn);
    console.log(`[${tag}] funcs:`, funcs);
  }
};


export function ProductPage({ pid }) {
  const [detail, setDetail] = useState("");
  const priductCb = useCallback(() => {
    setTimeout(() => {
      console.log("get detail from net");
      setDetail(`pid ${pid} detail`);
    }, 1000);
  }, [pid]);

  rec('priductCb',priductCb);
  return (
    <div>
      <div>{detail}</div>
      <div onClick={(e) => priductCb()}>getDetail</div>
    </div>
  );
}
