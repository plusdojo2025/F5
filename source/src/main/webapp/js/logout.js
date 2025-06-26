document.querySelector('.logout a').addEventListener('click', function(event) {
	const logout = confirm('本当にログアウトしますか？');
	if (!logout) {
    	event.preventDefault(); 
  	} 
});
