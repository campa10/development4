import React from 'react';

const PassParameter = () => {
  
  function sayHello(name) {
    alert(`hello, ${name}`);
  }
  
  return (
    <button onClick={() => sayHello('James')}>Greet</button>
  );
}

export default PassParameter;