import { useState } from "react";

export default function Button({ handleClick, text }) {
  // function handleClick() {
  //     console.log('Button clicked');
  // }
  const [index, setIndex] = useState(0);

  function clildClick(e) {
    setIndex(index + 1);
    console.log("child clicked");
  }

  return (
    <div>
      <button
        onClick={(e) => {
          e.stopPropagation(); // 阻止冒泡
          handleClick();
          clildClick(e);
        }}
      >
        {text ? text : "My Button"}
      </button>
      <p>{index}</p>
    </div>
  );
}
