import { useState } from "react";
import './App.css';

export default function LoginPage() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    function handleSubmit(e) {
        e.preventDefault();
        Login({username, password})
            .then((response) => {
                localStorage.clear();
                localStorage.setItem('tokenType', response.tokenType);
                localStorage.setItem('accessToken', response.accessToken);
                localStorage.setItem('refreshToken', response.refreshToken);
                console.log("login Success!");
            }).catch((error) => {
                if (error.response && error.response.data) {
                    switch (error.response.data) {
                        case 'username':
                        case 'password':
                            setError('아이디 혹은 비밀번호를 다시 확인해 주세요.');
                            break;
                        default:
                            console.log(error);
                    }
                } else {
                    console.log('Unexpected error:', error);
                    setError('로그인 중 오류가 발생했습니다.');
                }
            });
    }

    return (
        <form onSubmit={handleSubmit}>
            {error && <p className="error">{error}</p>}
            <input 
                type="text" 
                id='username'
                className="usernameInput"
                value={username}
                onChange={e => setUsername(e.target.value)}
            />
            <input 
                type="password"
                id="password"
                className="passwordInput"
                value={password}
                onChange={e => setPassword(e.target.value)}
            />
            <button type="submit">로그인</button>
        </form>
    );
}