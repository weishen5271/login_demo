let baseUrl = "";
switch (process.env.NODE_ENV) {
    case 'dev':
        baseUrl = "http://localhost:8777/"  //开发环境url
        break
    case 'serve':
        baseUrl = "http://localhost:8089/"   //生产环境url
        break
    default:
        baseUrl = "http://localhost:8777/"  //开发环境url
        break
}

export default baseUrl;
