export function Son({ fatherSay, sayFather }){

    return (
        <div>
            <div>{ fatherSay}</div>
            <input onChange={(e)=>sayFather(e.target.value)} placeholder="请输入"></input>
        </div>
    );    
}