# ItemClearLag - 고급 필터링 가이드

이 가이드는 ICL의 고급 필터링 기능을 설명합니다.

## 필터링 작동 방식

아이템 정리 시 다음 순서로 필터가 적용됩니다:

1. **차원 필터** - 제외된 차원은 완전히 건너뜁니다
2. **기존 필터** - `preserveNoPickupItems`, `preserveNoDespawnItems`
3. **화이트리스트/블랙리스트** - 두 모드 중 하나만 활성화됩니다
4. **인챈트 필터** - 인챈트된 아이템 보존
5. **모드 아이템 필터** - 바닐라가 아닌 아이템 보존
6. **희귀도 필터** - RARE/EPIC 아이템 보존

## 필터 설정 방법

### 1. 명령어로 설정 가능한 옵션

Boolean 타입 설정은 명령어로 변경할 수 있습니다:

```
/icl config set preserveEnchantedItems true
/icl config set preserveModItems true
/icl config set preserveRareItems true
/icl config set targetItemsOnly false
```

### 2. 설정 파일로만 설정 가능한 옵션

List 타입 설정은 `config/Icl/ICL.json` 파일을 직접 수정해야 합니다:

- `exemptItems` - 화이트리스트
- `targetItems` - 블랙리스트
- `excludedDimensions` - 제외할 차원

## 사용 예시

### 예시 1: 귀중한 아이템 모두 보호

```json
{
  "preserveEnchantedItems": true,
  "preserveModItems": true,
  "preserveRareItems": true,
  "exemptItems": [
    "minecraft:diamond",
    "minecraft:netherite_ingot",
    "minecraft:emerald"
  ]
}
```

### 예시 2: 네더와 엔드 제외

```json
{
  "excludedDimensions": [
    "minecraft:the_nether",
    "minecraft:the_end"
  ]
}
```

### 예시 3: 특정 아이템만 정리 (블랙리스트 모드)

```json
{
  "targetItemsOnly": true,
  "targetItems": [
    "minecraft:cobblestone",
    "minecraft:dirt",
    "minecraft:gravel",
    "minecraft:rotten_flesh"
  ]
}
```

### 예시 4: 모드 아이템은 보호하고 바닐라만 정리

```json
{
  "preserveModItems": true
}
```

### 예시 5: 희귀한 아이템 보호 (추천 설정)

```json
{
  "preserveEnchantedItems": true,
  "preserveModItems": true,
  "preserveRareItems": true,
  "exemptItems": [
    "minecraft:diamond",
    "minecraft:diamond_ore",
    "minecraft:emerald",
    "minecraft:netherite_scrap",
    "minecraft:netherite_ingot",
    "minecraft:ancient_debris"
  ]
}
```

**결과**: 
- **정리**: 모든 블록 (바닐라 + 모드), 바닐라 일반 아이템 (썩은 고기, 화살 등)
- **보존**: 인챈트된 아이템, RARE/EPIC 아이템, 모드 비블록 아이템 (도구, 무기 등), 화이트리스트 자원

**참고**: `preserveModItems`는 모드 블록은 정리하되, 모드 도구/무기/아이템은 보호합니다.

## 희귀도 시스템

⚠️ **중요**: 마인크래프트의 희귀도(Rarity)와 아이템의 가치는 다릅니다!

마인크래프트의 희귀도는 4단계로 나뉩니다:

- **COMMON** (흰색) - 일반 아이템
- **UNCOMMON** (노란색) - 흔하지 않은 아이템
- **RARE** (청록색) - 희귀 아이템
- **EPIC** (자주색) - 에픽 아이템

`preserveRareItems`를 true로 설정하면 RARE와 EPIC 아이템이 보존됩니다.

### EPIC 아이템 예시
- **네더라이트 장비** (검, 곡괭이, 갑옷 등) ✅
- 엔더 드래곤 알
- 인챈트된 황금 사과

### RARE 아이템 예시
- 인챈트된 책
- 황금 사과
- 음반
- 비컨
- 토템
- 삼지창
- 엘리트라

### ⚠️ COMMON 희귀도지만 귀중한 자원 아이템

**다음 아이템들은 희귀도가 COMMON이므로 `preserveRareItems`로 보호되지 않습니다:**

- 다이아몬드 (원석, 가공품, 블록) ❌
- 네더라이트 (파편, 주괴, 블록) ❌
  - 주의: 네더라이트 **장비**는 EPIC이라 보호됨 ✅
- 에메랄드 (원석, 가공품, 블록) ❌
- 고대 잔해 ❌
- 금/철 주괴, 블록 ❌

**이러한 자원 아이템을 보호하려면 `exemptItems`에 직접 추가하세요:**

```json
{
  "exemptItems": [
    "minecraft:diamond",
    "minecraft:diamond_ore",
    "minecraft:deepslate_diamond_ore",
    "minecraft:ancient_debris",
    "minecraft:netherite_scrap",
    "minecraft:netherite_ingot",
    "minecraft:emerald"
  ]
}
```

## 아이템 ID 찾는 방법

아이템 ID는 F3+H를 눌러서 고급 툴팁을 활성화하면 확인할 수 있습니다.

형식: `namespace:item_name`

- 바닐라 아이템: `minecraft:diamond`
- 모드 아이템: `modid:custom_item`

## 차원 ID

일반적인 차원 ID:

- 오버월드: `minecraft:overworld`
- 네더: `minecraft:the_nether`
- 엔드: `minecraft:the_end`
- 커스텀 차원: `modid:dimension_name`

## 성능 영향

모든 필터는 O(1) 또는 O(log n) 연산이며, 이미 ItemEntity만 순회하고 있어서 TPS에 거의 영향을 주지 않습니다 (< 0.1ms).

## 문제 해결

### 설정이 적용되지 않는 경우

1. 설정 파일이 올바른 JSON 형식인지 확인
2. `/icl reload` 명령어로 리로드
3. 서버 재시작

### 아이템이 여전히 삭제되는 경우

1. 필터 순서 확인 - 블랙리스트 모드가 활성화되어 있는지
2. 아이템 ID가 정확한지 확인
3. 로그에서 삭제된 아이템 개수 확인

## 추가 정보

더 자세한 정보는 README.md를 참고하세요.
