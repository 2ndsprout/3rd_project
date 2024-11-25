import axios from 'axios';

export function getAPI() {
    const api = axios.create({
        baseURL: 'http://localhost:8080',
        //baseURL: '배포후 주소',
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
        },
    });
    return api;
}