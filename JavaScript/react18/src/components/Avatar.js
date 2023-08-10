// function Avatar(props) {
//     let person = props.person;
//     let size = props.size;
//     // ...
//   }

function Name({ name }) {
  if (!name) {
    return null;
  }
  return (
    <div>
      <p>{name}</p>
    </div>
  );
}

// 这里的 {person, size} 和上面的写法是一样的
export default function Avatar({ person, size, name }) {
  return (
    <div>
      <img
        className="avatar"
        src={person.src}
        alt="Lin Lanying"
        width={size}
        height={size}
      />
      <Name name={name}></Name>
    </div>
  );
}
