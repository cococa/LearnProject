
let uid = 0;

export class Dep{
    
    constructor({name}){
        this.id = uid++;
        this.name = name
    }

}