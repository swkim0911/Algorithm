# case 2
def can_remove_with_non_pair(n, non_pair_elem, available_cards):
    for left_elem in non_pair_elem:
        if (n + 1 - left_elem) in available_cards:
            non_pair_elem.remove(left_elem)
            available_cards.remove((n + 1 - left_elem))
            return True

    return False


# case 3
def can_remove_with_available(n, available_cards):
    for available_card in available_cards:
        if (n + 1 - available_card) in available_cards:
            available_cards.remove(available_card)
            available_cards.remove((n + 1 - available_card))
            return True

    return False


def solution(coin, cards):
    answer = 1
    n = len(cards)
    own_cards = cards[:n // 3]  # 가지고 있는 카드 리스트
    available_cards = []  # 라운드가 진행되며 뽑을 카드 리스트
    idx = len(own_cards)
    pair_elem = []  # 가지고 있는 카드 중 n + 1을 만족하는 카드들
    non_pair_elem = []  # 가지고 있는 카드 중 n + 1을 만족하지 못하는 카드들

    for card in own_cards:
        if (n + 1 - card) in own_cards:
            if card not in pair_elem:
                pair_elem.append(card)
                pair_elem.append((n + 1 - card))
        else:
            non_pair_elem.append(card)

    while idx < n:
        available_cards.append(cards[idx])
        available_cards.append(cards[idx + 1])

		# case 1
        if pair_elem:
            removed = pair_elem[0]
            pair_elem.remove(removed)
            pair_elem.remove((n + 1 - removed))
        elif coin >= 1 and can_remove_with_non_pair(n, non_pair_elem, available_cards):
            coin -= 1
        elif coin >= 2 and can_remove_with_available(n, available_cards):
            coin -= 2
        else:
            break

        answer += 1
        idx += 2

    return answer