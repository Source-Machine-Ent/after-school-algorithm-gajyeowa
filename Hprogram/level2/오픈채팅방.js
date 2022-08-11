function solution(record) {
	var answer = [];
	let arr = [];
	let name = new Map();

	for (let el of record) {
		let split = el.split(" ");
		if (split[0] === "Enter") {
			arr.push([split[0], split[1]]); // ["Enter","uid1234"]
			name.set(split[1], split[2]); // 고유 id 기반으로 이름 맵핑. "uid1234" => "Muzi"
		} else if (split[0] === "Leave") {
			arr.push([split[0], split[1]]);
		} else if (split[0] === "Change") {
			name.set(split[1], split[2]);
		}
	}

	for (let el of arr) {
		let names = name.get(el[1]);
		if (el[0] === "Enter") {
			answer.push(`${names}님이 들어왔습니다.`);
		} else {
			answer.push(`${names}님이 나갔습니다.`);
		}
	}

	return answer;
}

// 삽입될 떄 마다 값을 배열을 사용해서 위치 저장
