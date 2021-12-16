function Login({ isAuth, userId, username, email }) {
  return (
    <>
      <article>
        <header>
          <h3>
            Welcome to our Final Sprint Project
            {isAuth && (
              <>
                <br />
                User ID: {localStorage.userId}
                <br /> Username: {localStorage.username}
                <br /> Email: {localStorage.email}
              </>
            )}
          </h3>
        </header>
        <div className="article_content">
          <h5>This is the generic search forum we have designed using React and Java</h5>
        </div>
        <footer>
          <a href="http://johnoneill.tech" target="_blank" rel="noreferrer">
            johnoneill.tech
          </a>
          <div className="footer_bar"></div>
        </footer>
      </article>
    </>
  );
}

export default Login;
