import axios from 'axios'
import baseUrl from '../api/baseUrl'

const request = axios.create({
    baseURL:baseUrl,
    // timeout: 3000
})

request.interceptors.request.use((config) => {
    return { ...config
    }
}, (err) => Promise.reject(err))


request.interceptors.response.use((res) => {
    // console.log(res, "响应拦截 ！！！")
    return res.data;
}, (err) => Promise.reject(err))
export default request;
