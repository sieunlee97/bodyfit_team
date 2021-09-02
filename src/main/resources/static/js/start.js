
function goOne() {
	main.style.WebkitAnimation = "fadeOut 1s";
	main.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q1.style.WebkitAnimation = "fadeIn 1s";
		q1.style.animation = "fadeIn 1s";
		setTimeout(() => {
			main.style.display = "none";
			q1.style.display = "block"
		}, 450)
	}, 450);
}

function goTwo() {
	q1.style.WebkitAnimation = "fadeOut 1s";
	q1.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q2.style.WebkitAnimation = "fadeIn 1s";
		q2.style.animation = "fadeIn 1s";
		setTimeout(() => {
			q1.style.display = "none";
			q2.style.display = "block"
		}, 450)
	}, 450);
}

function goThree() {
	q2.style.WebkitAnimation = "fadeOut 1s";
	q2.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q3.style.WebkitAnimation = "fadeIn 1s";
		q3.style.animation = "fadeIn 1s";
		setTimeout(() => {
			q2.style.display = "none";
			q3.style.display = "block"
		}, 450)
	}, 450);
}
function goFour() {
	q3.style.WebkitAnimation = "fadeOut 1s";
	q3.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q4.style.WebkitAnimation = "fadeIn 1s";
		q4.style.animation = "fadeIn 1s";
		setTimeout(() => {
			q3.style.display = "none";
			q4.style.display = "block"
		}, 450)
	}, 450);
}
function goFive() {
	q4.style.WebkitAnimation = "fadeOut 1s";
	q4.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q5.style.WebkitAnimation = "fadeIn 1s";
		q5.style.animation = "fadeIn 1s";
		setTimeout(() => {
			q4.style.display = "none";
			q5.style.display = "block"
		}, 450)
	}, 450);
}
function goSix() {
	q5.style.WebkitAnimation = "fadeOut 1s";
	q5.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q6.style.WebkitAnimation = "fadeIn 1s";
		q6.style.animation = "fadeIn 1s";
		setTimeout(() => {
			q5.style.display = "none";
			q6.style.display = "block"
		}, 450)
	}, 450);
}
function goSeven() {
	q6.style.WebkitAnimation = "fadeOut 1s";
	q6.style.animation = "fadeOut 1s";
	setTimeout(() => {
		q7.style.WebkitAnimation = "fadeIn 1s";
		q7.style.animation = "fadeIn 1s";
		setTimeout(() => {
			q6.style.display = "none";
			q7.style.display = "block"
		}, 450)
	}, 450);
}
