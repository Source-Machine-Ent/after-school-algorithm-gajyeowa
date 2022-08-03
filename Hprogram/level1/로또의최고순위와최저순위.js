function solution(lottos, win_nums) {
	const nice = [0, 0];
	// 몇개가 맞으면 등수가 몇등인지 테이블로 만들어줌
	const result = { 6: 1, 5: 2, 4: 3, 3: 4, 2: 5, 1: 6, 0: 6 };

	// lottos의 데이터를 비교해 당첨 번호라면 양쪽에 모두 더하여주고
	// 0 이라면 최고 등수에만 더해줌
	for (let i = 0; i < lottos.length; i++) {
		if (lottos[i] === 0) {
			nice[0] = nice[0] + 1;
		} else if (win_nums.includes(lottos[i])) {
			nice[0] = nice[0] + 1;
			nice[1] = nice[1] + 1;
		}
	}

	// 미리 저장시켜둔 테이블을 이용해 해당 등수를 출력
	return [result[nice[0]], result[nice[1]]];
}
