'use client';

import { useState } from "react";
import { Login } from "./API/AuthAPI";
import Header from "./layout/page";

export default function Home() {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  function Sumbit() {
    Login({ username, password })
      .then((response) => {
        localStorage.clear();
        localStorage.setItem('tokenType', response.tokenType);
        localStorage.setItem('accessToken', response.accessToken);
        localStorage.setItem('refreshToken', response.refreshToken);
        console.log("로그인 성공");
      }).catch((error) => {
        switch (error.response.data) {
          case 'username': { setError('아이디가 잘못되었습니다.'); break; }
          case 'password': { setError('잘못된 비밀번호입니다.'); break; }
          default:
            console.log(error);
        }

      });
  }
  return (
    <div className="App">
      <Header></Header>
      <div className='w-full h-screen'>
        <div className='flex flex-col items-center justify-center h-full relative bordered'>
          <label className='text-xs text-red-500 text-start w-[396px]'>{error}</label>
          <input id='username' type='text' className='w-[396px] h-[46px] input input-bordered rounded-[0]' style={{ outline: '0px' }} placeholder='아이디 입력' onFocus={e => e.target.style.border = '2px solid red'} onBlur={e => e.target.style.border = ''} onChange={e => setUsername(e.target.value)} />
          <input id='password' className='w-[396px] h-[46px] input input-bordered rounded-[0]' style={{ outline: '0px' }} placeholder='비밀번호 8자~20자' onFocus={e => e.target.style.border = '2px solid red'} onBlur={e => e.target.style.border = ''} onChange={e => setPassword(e.target.value)} />
          <div className='w-[396px] mt-1'><input type='checkbox' /> <label>비밀번호 확인</label></div>
          <button id='submit' className='border' onClick={() => Sumbit()}>로그인</button>
        </div>
        <p className='qwe'>dsadasd</p>
      </div>
    </div>
  );
}
