import VueMarkdownIt from "vue3-markdown-it";

function testCode(res) {
  return `
      ${res}
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
    console.log('--mounted-',methods);
    Object.keys(methods).forEach((element) => {
      if (element != "testClick" && element != 'mixJsCode') {
        console.log('--mounted-',this.$options.methods[element]);
        const code = {
          methodName: element,
          msg: this["msg_" + element] ? this["msg_" + element].toString() : "",
          code: testCode(this.$options.methods[element]),
        };
        this.codeArray.push(code);
      }
    });
  },
  methods: {
    mixJsCode(res) {
      return `
        #  
        \`\`\`javascript
         ${res}   
        \`\`\`
        ## 
        `;
    },
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
