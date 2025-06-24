document.getElementById('form').onsubmit = function(event) {
	event.preventDefault();

	const email = document.getElementById('email').value;
	const password = document.getElementById('password').value;
	const output = document.getElementById('output');

	if (email === '' && password === '') {
		output.textContent = 'メールアドレスとパスワードを入力してください。';
		} else if (email === '') {
			output.textContent = 'メールアドレスを入力してください。';
		} else if (password === '') {
			output.textContent = 'パスワードを入力してください。';
		} else {
			output.textContent = '';
this.submit(); 
}
};