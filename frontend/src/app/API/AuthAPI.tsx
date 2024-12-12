import { getAPI } from "./AxiosAPI";


export const AuthApi = getAPI();

AuthApi.interceptors.request.use(
    (config) => {
        const TOKEN_TYPE = localStorage.getItem("tokenType");
        let ACCESS_TOKEN = localStorage.getItem("accessToken");
        config.headers["Authorization"] = `${TOKEN_TYPE} ${ACCESS_TOKEN}`;
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);
AuthApi.interceptors.response.use(
    (response) => {
        return response
    }, async (error) => {
        // console.log(error)
        // 응답 에러 : 에러코드로 처리 방법 지정
        //  ex) locaStorage에 토큰이 없음 -> 안내 메세지 후 로그인 페이지로 redirect,
        //  ex) access token 만료 -> refreshtoken으로 access토큰 재요청
        return Promise.reject(error);
    }
);

/** LOGIN API */
interface LoginProps {
    username: string;
    password: string;
}
export const Login = async (data: LoginProps) => {
    const response = await AuthApi.post(`/api/auth/login`, data);
    return response.data;
}