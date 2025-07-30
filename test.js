import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 100,
  duration: '1s',
};

export default function () {
  const userId = Math.floor(Math.random() * 1000) + 1;

  const payload = JSON.stringify({
    userId: userId,
    coffeeName: "Americano"  // ← 이 부분만 실제 DB 값으로 수정
  });

  const headers = { 'Content-Type': 'application/json' };

  const res = http.post('http://localhost:8080/api/coffee/orders', payload, { headers });

  check(res, {
    'status is 200': (r) => r.status === 200,
    'has orderId': (r) => JSON.parse(r.body).orderId !== undefined,
    'has rank': (r) => JSON.parse(r.body).rank !== undefined,
  });
}