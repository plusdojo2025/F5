const textModal = document.getElementById("text-modal");
const modalText = document.getElementById("modal-text");
const modalImage = document.getElementById("modal-img");
const okText = document.getElementById("ok-text");

  /*すべての画像にイベントを追加*/
  document.querySelectorAll('.washimg').forEach(img =>{
    img.addEventListener('click', ()=>{
      const message = img.getAttribute("data-info") || "この画像に説明はありません。";
      modalText.textContent = message;
      modalImage.src = img.src; // クリックされた画像をコピー
      textModal.style.display = "block";
    });
  });

  // モーダル閉じる動作
  okText.onclick = () => {
    textModal.style.display = "none";
  }

  window.onclick = (event) => {
    if (event.target === textModal) {
      textModal.style.display = "none";
    }
  };