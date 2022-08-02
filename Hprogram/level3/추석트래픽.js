function solution(lines) {
	let answer = 0;
	let count = 0;
	let list = [];

	for (let i = 0; i < lines.length; i++) {
		const [date, times, duration] = lines[i].split(" ");
		const millisecond = milliSeconds(times);
		const durationTime = duration.substr(0, duration.length - 1) * 1000; // s 삭제 및 밀리초 변환
		const startTime = millisecond - durationTime + 1; // 시간 흐름 포함을 위해 0.001초를 더해준다.
		const endTime = millisecond + 999; // 1초만큼의 진행만을 고려하기 때문에 위 시간 흐름 포함 1+999 총 1000ms 만큼 계산.

		list.push(["S", startTime], ["E", endTime]);
	}
	list.sort((a, b) => (a[1] !== b[1] ? a[1] - b[1] : -1)); // 시간기준으로 오름차순 정렬

	// 시간 기준으로 정렬되었기 때문에 Start가 체크되면 count++, End가 체크되면 count-- 한다.
	for (const el of list) {
		if (el[0] === "S") {
			count++;
		} else {
			count--;
		}

		answer = Math.max(answer, count);
	}

	return answer;
}

// 밀리초 변환
const milliSeconds = (time) => {
	const hour = (time[0] * 10 + time[1] * 1) * 60 * 60;
	const minute = (time[3] * 10 + time[4] * 1) * 60;
	const seconds = time[6] * 10 + time[7] * 1;
	const millis = time[9] * 100 + time[10] * 10 + time[11] * 1;
	const amount = (hour + minute + seconds) * 1000 + millis;

	return amount;
};
