// "use client";
// import { Client } from '@stomp/stompjs';
// import SockJS from 'sockjs-client';

// export interface Subscribe {
//     location: string,
//     active: (r: any) => void,
// }
// export function getSocket(subs: Subscribe[], setIsReady: () => void) {
//     const Socket = new Client({
//         webSocketFactory: () => {
//             // return new SockJS("http://localhost:8080/api/ws-stomp");
//             return new SockJS("http://server.starj.kro.kr:18186/api/ws-stomp");
//         },
//         // beforeConnect: () => {
//         //     console.log("beforeConnect");
//         // },
//         // debug(str) {
//         //     console.log(`debug`, str);
//         // },        
//         onWebSocketError: () => {
//             window.location.reload();
//         },
//         reconnectDelay: 50000, // 자동 재연결
//         heartbeatIncoming: 4000,
//         heartbeatOutgoing: 4000,
//         onConnect: () => {
//             subs.forEach(sub => {
//                 Socket.subscribe(sub.location, (e) => sub.active(JSON.parse(e.body)));
//             })
//             const interval = setInterval(() => { setIsReady(); clearInterval(interval); }, 100);
//         }
//     });
//     Socket.activate();
//     return Socket;
// }
