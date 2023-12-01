import { useState } from "react";
import { Son } from "./Son";
import { ProductPage } from "./ProductPage";




export function Father() {
  const [fatherSay, sayFather] = useState("");
  const [pid, setPid] = useState(1);
  const [show, setShow] = useState(true);




  return (
    <div>
      <div>{fatherSay}</div>  
      <Son fatherSay={fatherSay} sayFather={sayFather}></Son>
      {show && <ProductPage pid={pid}></ProductPage>}
      <button onClick={(e)=>{setPid(new Date().getTime())}}>test useCallback</button>
      <button onClick={(e)=>{setShow(!show)}}>setShow</button>
    </div>
  );
}
