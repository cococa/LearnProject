class Observer {
    value = {};
    constructor(value) {
      this.value = value;
      this.walk(this);
    }

    walk(data, value) {
      // Object.keys(data.value).forEach((key) => {
      const keys = Object.keys(data.value);    
      for (var i = 0; i < keys.length; i++) {  
        const key = keys[i]
        this.defineReactive(this, key)
      };
    }

    defineReactive(data, key, val) {
        console.log("walk key =>> ", key);
        val = this.value[key];
        Object.defineProperty(data, key, {
          enumerable: true,
          configurable: true,
          get() {
            console.log("get" + key);
            return val;
          },
          set(newValue) {
            if (newValue === val) {
              return;
            }
            console.log("set" + key + " " + val + "==>" + newValue);
            val = newValue;
          },
        });
        
    }

  }

  let ob = new Observer({
    name: "shencocoa",
    age: 18,
    langs:['swift','java']
  });

  ob.name = "123";
  console.log(ob.name);

  console.log(ob.age);
  
  ob.langs.push('python');
  console.log(ob.langs);