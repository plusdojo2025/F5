// アップロード画像のプレビュー差し替え
document.getElementById('clothes_img').addEventListener('change', function(event) {
    const file = event.target.files[0];

    if (file && file.type.startsWith('image/')) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('imagePreview').src = e.target.result;
        }
        reader.readAsDataURL(file);
    }
});

const form = document.querySelector('form');

/*
if (form) {
    const memo = document.getElementById('remarks');
    const categorySelect = document.getElementById('category_id');
    const washingMarks = document.querySelectorAll('input[name="washing_mark"]');

    form.addEventListener('submit', function(e) {
        const submitter = document.activeElement;

        // 「削除」ボタンの場合
        if (submitter && submitter.value === "削除") {
            if (!confirm("本当に削除しますか？")) {
                e.preventDefault();
            }
            return;
        }

        // 共通バリデーション
        if (memo.value.length > 100) {
            alert("メモは100文字以内で入力してください。");
            e.preventDefault();
            return;
        }

        if (!categorySelect.value) {
            alert("衣類カテゴリーを選択してください。");
            e.preventDefault();
            return;
        }

        const anyChecked = Array.from(washingMarks).some(mark => mark.checked);
        if (!anyChecked) {
            alert("洗濯表示を1つ以上選択してください。");
            e.preventDefault();
            return;
        }

        // 更新ボタンの確認アラート（削除と同様）
        if (submitter && submitter.value === "更新") {
            if (!confirm("本当に更新しますか？")) {
                e.preventDefault();
            }
        }
    });
}
*/

document.getElementById('deleteButton').addEventListener('click', function(event) {
	var confirmation = confirm('本当に削除しますか？');
	if (!confirmation) {
		event.preventDefault();
	}
});


// 更新ボタンのクリックイベント
document.getElementById('updateButton').addEventListener('click', function(event) {
    // バリデーションチェックを先に行う
    var category = document.getElementById('category_id');
    if (!category.value) {
        alert('カテゴリーを選択してください');
        event.preventDefault(); // 更新をキャンセル
        return;
    }

    var washingMarks = document.getElementsByName('washing_mark');
    var isWashingSelected = Array.from(washingMarks).some(input => input.checked);
    if (!isWashingSelected) {
        alert('少なくとも1つの洗濯表示を選択してください');
        event.preventDefault(); // 更新をキャンセル
        return;
    }

    var remarks = document.getElementById('remarks').value;
    if (remarks.length > 100) {
        alert('メモは100文字以内で入力してください');
        event.preventDefault(); // 更新をキャンセル
        return;
    }

    // バリデーションを通過した場合に確認ダイアログを表示
    var confirmation = confirm('本当に更新しますか？');
    if (!confirmation) {
        event.preventDefault(); // 更新をキャンセル
    }
});
// 登録ボタンのクリックイベント
document.getElementById('registButton').addEventListener('click', function(event) {
    // バリデーションチェックを先に行う
    var category = document.getElementById('category_id');
    if (!category.value) {
        alert('カテゴリーを選択してください');
        event.preventDefault(); // 更新をキャンセル
        return;
    }

    var washingMarks = document.getElementsByName('washing_mark');
    var isWashingSelected = Array.from(washingMarks).some(input => input.checked);
    if (!isWashingSelected) {
        alert('少なくとも1つの洗濯表示を選択してください');
        event.preventDefault(); // 更新をキャンセル
        return;
    }

    var remarks = document.getElementById('remarks').value;
    if (remarks.length > 100) {
        alert('メモは100文字以内で入力してください');
        event.preventDefault(); // 更新をキャンセル
        return;
    }
});
