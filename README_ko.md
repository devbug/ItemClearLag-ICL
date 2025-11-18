[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1001584?style=for-the-badge&logo=curseforge&logoColor=%230d0d0d&labelColor=%23f16436&color=%230d0d0d)](https://www.curseforge.com/minecraft/mc-mods/itemclearlag) [![Modrinth Downloads](https://img.shields.io/modrinth/dt/NJcJEXNc?style=for-the-badge&logo=modrinth&color=%231bd96a)](https://modrinth.com/mod/itemclearlag)

# ItemClearLag (ICL)

ItemClearLag (ICL)은 바닥에 떨어진 아이템을 주기적으로 제거하여 서버 성능을 개선하는 마인크래프트 모드입니다. 이 모드는 아이템이 쌓여 렉이 발생할 수 있는 다중 플레이어 서버에 특히 유용합니다.

## 설치 방법

1. Fabric, Forge 또는 NeoForge가 설치되어 있는지 확인하세요.
2. [릴리즈 페이지](https://github.com/VeiTrr/ItemClearLag-ICL/releases)에서 최신 버전의 ICL을 다운로드하세요.
3. 다운로드한 .jar 파일을 `mods` 폴더에 넣으세요.
4. 서버 또는 게임을 시작하세요.

## 명령어

채팅에 `/icl`을 입력하면 사용 가능한 모든 명령어를 확인할 수 있습니다.

ICL의 메인 명령어는 `/icl`이며, 다음과 같은 하위 명령어가 있습니다:

- `/icl forceclean`: 바닥에 있는 모든 아이템을 즉시 정리합니다.
- `/icl reload`: ICL을 다시 로드합니다.
- `/icl config set <key> [value]`: 설정 값을 변경합니다. 현재 설정 값을 보려면 `/icl config set <key>`를 사용하세요.
- `/icl cancel [seconds]`: 다음 정리를 취소합니다. 초 단위 숫자를 입력하면 해당 시간 후에 다음 정리가 예약됩니다.

## 설정

설정 값은 `/icl config set` 명령어로 변경할 수 있습니다. 주요 설정 값:

- `Delay`: 자동 아이템 정리 사이의 지연 시간(초).
- `NotificationDelay`: 정리 전 알림 간 지연 시간(초).
- `NotificationStart`: 정리 전 알림이 시작되는 시간(초).
- `NotificationTimes`: 정리 전 전송할 알림 횟수.
- `CountdownStart`: 정리 전 카운트다운이 시작되는 시간(초).
- `doNotificationCountdown`: 정리 전 카운트다운 표시 여부.
- `doNotificationSound`: 알림 전송 시 소리 재생 여부.
- `doLastNotificationSound`: 마지막 알림 전송 시 소리 재생 여부.
- `NotificationSound`: 알림 시 재생할 소리.
- `LastNotificationSound`: 마지막 알림 시 재생할 소리.
- `NotificationLang`: 알림 언어.
- `NotificationColor`: 알림 색상.
- `RequireOp`: ICL 명령어 사용 시 OP 권한 필요 여부.
  - ***참고:*** fabric-permissions 모드가 설치된 경우 이 설정은 사용되지 않으며, 권한 관리자를 사용하세요.
- `RequireOpCancel`: 정리 취소 시 OP 권한 필요 여부.
  - ***참고:*** fabric-permissions 모드가 설치된 경우 이 설정은 사용되지 않으며, 권한 관리자를 사용하세요.
- `preserveNoDespawnItems`: 디스폰되지 않도록 설정된 아이템 보존 여부.
- `preserveNoPickupItems`: 픽업 불가능하도록 설정된 아이템 보존 여부.

### 고급 아이템 필터링

- `preserveEnchantedItems`: 인챈트된 아이템 보존 여부.
- `preserveModItems`: 모드 아이템(바닐라가 아닌 아이템) 보존 여부.
- `preserveRareItems`: RARE 또는 EPIC 희귀도 아이템 보존 여부 (예: 네더라이트 **장비**, 드래곤 알, 인챈트된 황금 사과).
  - **주의**: 다이아몬드, 네더라이트 주괴, 에메랄드, 고대 잔해 같은 자원 아이템은 COMMON 희귀도를 가지며 이 설정으로 보호되지 않습니다. 대신 `exemptItems`에 추가하세요.
- `targetItemsOnly`: 블랙리스트 모드 활성화. true일 경우 `targetItems`에 있는 아이템만 정리됩니다.
- `exemptItems`: 절대 정리되지 않을 아이템 ID 목록 (화이트리스트). 설정 파일에서 편집. 예시: `["minecraft:diamond", "minecraft:netherite_ingot"]`
- `targetItems`: `targetItemsOnly`가 true일 때 정리할 아이템 ID 목록 (블랙리스트). 설정 파일에서 편집.
- `excludedDimensions`: 아이템 정리에서 제외할 차원 ID 목록. 설정 파일에서 편집. 예시: `["minecraft:the_nether", "minecraft:the_end"]`

**참고**: 리스트 타입 설정(`exemptItems`, `targetItems`, `excludedDimensions`)은 명령어가 아닌 설정 파일(`config/Icl/ICL.json`)에서 직접 편집해야 합니다.

## 권한

ICL은 fabric-permissions 통합을 제공하여 각 명령어에 권한을 설정할 수 있습니다. 권한 목록:

- `icl.forceclean`: 플레이어가 `/icl forceclean` 명령어를 사용할 수 있도록 허용.
- `icl.reload`: 플레이어가 `/icl reload` 명령어를 사용할 수 있도록 허용.
- `icl.config`: 플레이어가 `/icl config` 명령어를 사용할 수 있도록 허용.
- `icl.cancel`: 플레이어가 `/icl cancel` 명령어를 사용할 수 있도록 허용.

## 라이선스

ICL은 MIT 라이선스로 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.
