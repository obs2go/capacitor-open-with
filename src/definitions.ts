declare module '@capacitor/core' {
  interface PluginRegistry {
    Obs2goOpenWith: Obs2goOpenWithPlugin;
  }
}

export interface OpenWithPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
