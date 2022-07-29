function solution(s) {
	let answer = s.length;

	for (let i = 1; i <= Math.floor(s.length / 2); i++) {
		let str = "";
		let count = 1;
		let present = s.substr(0, i);

		for (let j = i; j <= s.length; j += i) {
			let next = s.substr(j, i);

			if (present === next) {
				count += 1;
			} else {
				if (count === 1) {
					str = str + present;
				} else {
					str = str + count + present;
				}
				count = 1;
				present = next;
			}
		}
		if (count === 1) {
			str = str + present;
		} else {
			str = str + count + present;
		}
		if (answer > str.length) {
			answer = str.length;
		}
	}

	return answer;
}
