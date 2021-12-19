function Login({ isAuth, authToken }) {
  return (
    <>
      <article>
        <header>
          <h3>
            Welcome to our Final Sprint Project
            {isAuth && (
              <>
                <br />
                User ID: <strong>{localStorage.userId}</strong>
                <br /> Username: <strong>{localStorage.username}</strong>
                <br /> Email: <strong>{localStorage.email}</strong>
                <br /> Local Storgae: <strong>{localStorage.token}</strong>
                <br /> UseState: <strong>{authToken}</strong>
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
