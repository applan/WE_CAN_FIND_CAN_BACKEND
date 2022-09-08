![붙임3  제 9ȸ 대한민국 SW융합 해커톤 대회 포스터](https://user-images.githubusercontent.com/48544100/186495452-4c7fdfaf-3ca8-4ec7-834d-babb4024ae0f.jpg)
# 🔥 개발 배경
- 배수로 쓰레기 막힘 문제 대두, 폭우시 원활한 배수에 차질이 생겨 홍수 재난으로 발전되는 상황도 발생함.
- 처리되지 않는 쓰레기로 수질오염을 야기시킴.
- 쓰레기 통에 가득찬 쓰레기 악취로 인해서 국민들에게 불쾌감을 줌

# 👥 · Members
| Name                                       | Position |
|--------------------------------------------|----------|
| [NooryKwon](https://github.com/NooryKwon)  | BACKEND  |
| [applan](https://github.com/applan)        | BACKEND  |
| [Jun Shin](https://github.com/greenthings) | MOBILE   |
| [hhp227](https://github.com/hhp227)        | MOBILE   |

# 📅 · 기간
- 2022.09.16 ~ 2022.09.18

# 📲 · BACKEND TECH
<div>
<img width="70" alt="SpringBoot" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
<img width="70" alt="Docker" src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white">
<img width="110" alt="ES" src="https://img.shields.io/badge/Elasticsearch-005571?style=for-the-badge&logo=Elasticsearch&logoColor=white">
<img width="100" alt="AWS" src="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
</div>

# 📱 · MOBILE TECH
<div>
<img width="50" alt="IOS" src="https://img.shields.io/badge/IOS-232F3E?style=for-the-badge&logo=IOS&logoColor=white">
<img width="60" alt="ES" src="https://img.shields.io/badge/Swift-F05138?style=for-the-badge&logo=Swift&logoColor=white">
</div>

# 📈 PUSH LEVEL
- Revert
  - PUSH 롤백 
- Core
  - Project 설정, 연동, API 생성, (VO, DTO..) 생성
- Fix
  - Error 코드 수정
- Refactor
  - 의미나 동작에 영향을 주지 않는 상태에서 가독성, 재사용성 또는 구조, 코드 개선
- Simple
  - 간단한 수정 (README.md 등), 주석 등 간단한 수정

# 🗄️ 패키지 구조
- ctrl: Controller 비즈니스 로직
- dao: 검색엔진 연동 비즈니스 로직
  - impl: Dao Interface implements(구현체) 목록
- domain: VO,DTO 등 사용하는 Model 정보 모음
- prop: 프로젝트 환경 설정, 사용하는 상수 모음
- runner: 프로젝트 시작시 동작하는 Runner 구현체가 담겨있는 패키지
- service: Dao를 호출하기 전 전처리 및 서비스 구현
  - impl: Service Interface implements(구현체) 목록
- util: 프로젝트에 사용하는 다양한 Util 모음
---


# 📚 TODO
### 셋팅
- [x] Elasticsearch 연동
- [x] model 생성
  - [x] Trash (쓰레기)
  - [ ] Report (신고 데이터)
- [ ] Runner 생성 후 
  - [ ] Elasticsearch 인덱스 자동 생성 

### 기능
- [ ] 쓰레기통 데이터 조회 API 기능 개발
- [ ] 쓰레기통 데이터 추가&수정 API 기능 개발
- [ ] 신고하기 삽입