import "./index.css";
import { useState } from "react";

export default function MoveContainer({}) {
  function handleMove(e) {
    console.log(e);
    setPosition((old) => {
      console.log("setPosition", old);
      return {
        x: e.clientX,
        y: e.clientY,
      };
    });
  }

  const [position, setPosition] = useState({ x: 0, y: 0 });
  return (
    <div className="container" onPointerMove={handleMove}>
      <h4>移动鼠标</h4>
      <p
        className="pointer"
        style={{ left: position.x - 5, top: position.y - 5 }}
      ></p>
    </div>
  );
}
