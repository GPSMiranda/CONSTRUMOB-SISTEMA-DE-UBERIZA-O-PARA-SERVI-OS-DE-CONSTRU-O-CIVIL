# ConstruMOB — MVP Visual

Interface web responsiva e instalável, criada a partir dos fluxos e protótipos do projeto. Os dados desta camada são demonstrativos e as ações são simuladas no navegador.

## Executar no desktop

Com Node.js instalado:

```powershell
node server.js
```

Abra `http://localhost:4173`.

## Executar no smartphone

1. Conecte o desktop e o smartphone à mesma rede Wi-Fi.
2. Descubra o IPv4 do desktop com `ipconfig`.
3. Execute `node server.js` neste diretório.
4. No smartphone, abra `http://IP-DO-DESKTOP:4173`.

O manifesto web permite instalar o MVP como um app na tela inicial quando o navegador oferecer essa opção.

## APK

O ambiente desta execução não possui Android SDK, Gradle ou `adb`; por isso não foi gerado um binário APK inválido ou não verificável. O MVP está pronto para empacotamento como WebView/PWA. Para gerar o APK em uma máquina com Android Studio, use Capacitor ou um projeto Android WebView apontando para esta pasta e execute `./gradlew assembleDebug`. O arquivo esperado será `app/build/outputs/apk/debug/app-debug.apk`.

Para produção, substitua os dados demonstrativos por chamadas aos endpoints do Spring Boot e gere uma assinatura Android própria antes da distribuição.
