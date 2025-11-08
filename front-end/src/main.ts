import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

import { environment } from './environments/environment.dev';

bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));

