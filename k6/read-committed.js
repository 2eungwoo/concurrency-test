import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 100,
  duration: '1s',
  iterations: 100, // 각 vu당 1회
};

export default function () {
  const url = 'http://localhost:8080/api/coffee/orders/read-committed';
  const payload = JSON.stringify({
    userId: Math.floor(Math.random() * 10000), // 유저 ID는 적당히 랜덤하게
    coffeeName: 'Americano'                    // DB에 존재하는 이름과 정확히 일치해야 함
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const res = http.post(url, payload, params);

  check(res, {
    'status is 200': (r) => r.status === 200
  });
}