const files = require.context('./', true, /^\.\/\w+\/index\.js$/);
export default files.keys().reduce((prev, cur) => {
    prev = Object.assign(prev,files(cur));
    return { ...prev };
}, {});
