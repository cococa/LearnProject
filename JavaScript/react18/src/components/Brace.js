const person = {
  name: "aaa",
  color: 'green',
  theme: {
    backgroundColor: 'black',
    color: 'pink'
  }
};

export default function Brace() {
  return (
    <div>
      <p style={ person.theme }>{person.name}</p>
    </div>
  );
}
