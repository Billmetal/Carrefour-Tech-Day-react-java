import React from 'react';
import { useRoutes } from 'react-router';

import myRoutes from './routes';

const App = (props) => {

const appRoutes = useRoutes(myRoutes)

  return (
    <>
      {appRoutes}
    </>
  );
}

export default App;
