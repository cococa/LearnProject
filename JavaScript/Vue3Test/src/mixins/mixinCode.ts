import VueMarkdownIt from "vue3-markdown-it";



function testCode(res) {
  return `
  #  
  \`\`\`javascript
   ${res}   
  \`\`\`
  ## 
  `;
}


const mixinCode = {
  data() {
    return {
      codeArray: [],
      
    };
  },
  created() {},
  mounted() {
    var methods = this.$options.methods;
    Object.keys(methods).forEach((element) => {
      if (element != "testClick") {
        const code = {
          methodName: element,
          msg: this['msg_'+element] ? this['msg_'+element].toString() : "",
          code: testCode(this.$options.methods[element]),
        };
        this.codeArray.push(code);
      }
    });
  },
  methods: {
    testClick(mName) {
      if (mName) {
        var vueMethods = this.$options.methods;
        let m = vueMethods[mName];
        m.call(this);
      }
    },
  },
};

export default mixinCode;
