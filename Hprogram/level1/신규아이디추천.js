function solution(new_id) {
	// 1단계
	let first = new_id.toLowerCase();
	// 2단계
	let second = first.replace(/[^\w-._]+/g, "");

	// 3단계
	let third = [];
	for (let i = 0; i < second.length; i++) {
		if (second[i] === "." && second[i + 1] === ".") {
			continue;
		} else {
			third.push(second[i]);
		}
	}

	// 4단계
	if (third[0] === ".") {
		third.splice(0, 1);
	}

	if (third[third.length - 1] === ".") {
		third.splice(third.length - 1, 1);
	}

	// 5단계
	if (third.length === 0) {
		third.push("a");
	}

	// 6단계
	let six = third.slice(0, 15);
	if (six[six.length - 1] === ".") {
		six.splice(six.length - 1, 1);
	}

	//7단계
	while (six.length <= 2) {
		six.push(six[six.length - 1]);
	}

	return six.join("");
}
