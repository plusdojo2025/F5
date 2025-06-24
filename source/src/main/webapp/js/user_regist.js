document.getElementById('regist_form').onsubmit = function(event) {
    event.preventDefault();

    const nickname = document.getElementById('nickname').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value;
    const passwordCheck = document.getElementById('password_check').value;
    const output = document.getElementById('output') || createOutput();
    const errors = [];

    // ニックネーム
    if (nickname === '') {
        errors.push('ニックネームを入力してください。');
    }

    // メールアドレス
    if (email === '') {
        errors.push('メールアドレスを入力してください。');
    }

    // パスワード
    if (password === '') {
        errors.push('パスワードを入力してください。');
    } else {
        // バリデーションチェック
        const pattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-={}[\]:;"'<>,.?/\\|])[A-Za-z\d!@#$%^&*()_+\-={}[\]:;"'<>,.?/\\|]{8,}$/;
        if (!pattern.test(password)) {
            errors.push('パスワードは記号を含む英数字8文字以上で入力してください。');
        }
    }

    // パスワード確認
    if (passwordCheck === '') {
        errors.push('パスワード確認を入力してください。');
    }

    // パスワード照合
    if (password !== '' && passwordCheck !== '' && password !== passwordCheck) {
        errors.push('パスワードが一致しません。');
    }

    // 送信
    output.textContent = '';
    this.submit();
};